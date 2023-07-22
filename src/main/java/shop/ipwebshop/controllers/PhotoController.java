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

@RestController
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

}
