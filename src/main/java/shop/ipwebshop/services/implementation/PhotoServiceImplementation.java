package shop.ipwebshop.services.implementation;

import org.apache.commons.io.IOUtils;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.*;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import shop.ipwebshop.base.CrudJpaService;
import shop.ipwebshop.constants.ImgBBConsts;
import shop.ipwebshop.models.dto.Photo;
import shop.ipwebshop.models.entities.PhotoEntity;
import shop.ipwebshop.models.response.PhotoUploadResponse;
import shop.ipwebshop.repositories.PhotoEntityRepository;
import shop.ipwebshop.services.PhotoService;

import java.io.IOException;
import java.util.Base64;
import java.util.List;


@Service
public class PhotoServiceImplementation extends CrudJpaService<PhotoEntity,Integer> implements PhotoService {
    private final PhotoEntityRepository repository;
    private final ModelMapper mapper;

    public PhotoServiceImplementation(PhotoEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, PhotoEntity.class);
        this.repository = repository;
        this.mapper = modelMapper;
    }

    @Override
    public Photo uploadPhoto(Integer productId, MultipartFile file) throws IOException {
        String imgbbApiKey = ImgBBConsts.IMGBB_API_KEY;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        byte[] imageBytes = IOUtils.toByteArray(file.getInputStream());
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", base64Image);
        body.add("key",imgbbApiKey);
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<PhotoUploadResponse> responseEntity = restTemplate.postForEntity(
                "https://api.imgbb.com/1/upload",
                requestEntity,
                PhotoUploadResponse.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            PhotoUploadResponse response = responseEntity.getBody();
            if (response != null && response.isSuccess()) {
                String photoUrl = response.getData().getUrl();
                Photo photo = new Photo();
                photo.setPhotoUrl(photoUrl);
                photo.setProductId(productId);
                return super.insert(photo,Photo.class);
            } else {
                // Handle the case where the response is null or the upload was not successful
                return null;
            }
        } else {
            // Handle the case where the API request was not successful
            return null;
        }
    }

    @Override
    public List<Photo> getAllByProductId(Integer id){
        return repository
                .getAllByProductId(id)
                .stream()
                .map(m->mapper.map(m,Photo.class))
                .toList();
    }
}
