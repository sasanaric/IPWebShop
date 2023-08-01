export class User {
    id: number | null;
    firstName: string | null;
    lastName: string | null;
    username: string | null;
    password: string | null;
    city: string | null;
    email: string | null;
    role: string | null;
    avatarUrl: string | null
  
    constructor(id?: number, firstName?: string, lastName?: string, username?: string, password?: string, city?: string, email?: string, role?: string, avatarUrl?: string) {
      this.id = id || null;
      this.firstName = firstName || null;
      this.lastName = lastName || null;
      this.username = username || null;
      this.password = password || null;
      this.city = city || null;
      this.email = email || null;
      this.role = role || null;
      this.avatarUrl = avatarUrl || null;
    }
  }
