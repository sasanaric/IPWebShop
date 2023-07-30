import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Photo } from '../models/photo';

@Injectable({
  providedIn: 'root'
})
export class PhotoService {
  private photosUrl: string;
  constructor(private http: HttpClient) { 
    this.photosUrl = 'http://localhost:8080/photos';
  }

  getPhotosByProductId(id: number): Observable<Photo[]> {
    return this.http.get<Photo[]>(`${this.photosUrl}/product/${id}`);
  }

  getFirstPhotoByProductId(id: number): Observable<Photo>{
    return this.http.get<Photo>(`${this.photosUrl}/product/${id}/first-photo`);
  }
}
