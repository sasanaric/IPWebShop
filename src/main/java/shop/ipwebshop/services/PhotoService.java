package shop.ipwebshop.services;

import org.springframework.web.multipart.MultipartFile;
import shop.ipwebshop.base.CrudService;
import shop.ipwebshop.models.dto.Photo;

import java.io.IOException;
import java.util.List;

public interface PhotoService extends CrudService<Integer> {
    Photo uploadPhoto(Integer productId, MultipartFile file) throws IOException;
    List<Photo> getAllByProductId(Integer id);
}
