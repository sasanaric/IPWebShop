export class Photo {
    id: number | null;
    photoUrl: string | null;
    productId: number | null;
  
    constructor(id?: number, photoUrl?: string, productId?: number) {
        this.id = id || null;
        this.photoUrl = photoUrl || null;
        this.productId = productId || null;
    }
  }
  