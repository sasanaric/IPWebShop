export class Product {
    id: number | null;
    title: string | null;
    description: string | null;
    price: number | null; 
    state: string | null;
    postedTime: Date | null; 
  
    constructor(
      id?: number, 
      title?: string, 
      description?: string, 
      price?: number, 
      state?: string, 
      postedTime?: Date
    ) {
      this.id = id || null;
      this.title = title || null;
      this.description = description || null;
      this.price = price || null;
      this.state = state || null;
      this.postedTime = postedTime || null;
    }
  }