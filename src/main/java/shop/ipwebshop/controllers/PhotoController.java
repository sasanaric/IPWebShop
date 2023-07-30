package shop.ipwebshop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shop.ipwebshop.base.CrudController;
import shop.ipwebshop.models.dto.Photo;
import shop.ipwebshop.models.requests.PhotoRequest;
import shop.ipwebshop.services.PhotoService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/photos")
public class PhotoController extends CrudController<Integer, PhotoRequest, Photo> {
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        super(Photo.class, photoService);
        this.photoService = photoService;
    }

    @PostMapping("/upload/{id}")
    public ResponseEntity<Photo> uploadPhoto(@RequestParam("file")MultipartFile file, @PathVariable Integer id) throws IOException{
        Photo photo = photoService.uploadPhoto(id,file);
        if(photo.getPhotoUrl() != null){
            return ResponseEntity.ok(photo);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/product/{id}")
    public List<Photo> getPhotosByProductId(@PathVariable Integer id){
        return photoService.getAllByProductId(id);
    }

    @GetMapping("/product/{id}/first-photo")
    public Photo getFirstPhotoByProductId(@PathVariable Integer id){
        List<Photo> photos = photoService.getAllByProductId(id);
        if (!photos.isEmpty()) {
            return photos.get(0);
        } else {
            Photo noImage = new Photo();
            noImage.setPhotoUrl("https://i.ibb.co/VNvhtZJ/Screenshot-2023-07-29-220419.png");
            return noImage;
        }
    }

}
