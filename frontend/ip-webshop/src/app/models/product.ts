export class Product {
    id: number | null;
    title: string | null;
    description: string | null;
    price: number | null; 
    state: string | null;
    postedTime: Date | null;
    userId: number | null;
    userUsername: string | null; 
    userAvatarUrl: string | null;
    userLocation: string | null;
    constructor(
      id?: number, 
      title?: string, 
      description?: string, 
      price?: number, 
      state?: string, 
      postedTime?: Date,
      userId?: number,
      userUsername?: string,
      userAvatarUrl?: string,
      userLocation?: string
    ) {
      this.id = id || null;
      this.title = title || null;
      this.description = description || null;
      this.price = price || null;
      this.state = state || null;
      this.postedTime = postedTime || null;
      this.userId = userId || null;
      this.userUsername = userUsername || null;
      this.userAvatarUrl = userAvatarUrl || null;
      this.userLocation = userLocation || null;
    }
  }