export class User {
    id: number | null;
    firstname: string | null;
    lastname: string | null;
    username: string | null;
    password: string | null;
    city: string | null;
    email: string | null;
    role: string | null;
  
    constructor(id?: number, firstname?: string, lastname?: string, username?: string, password?: string, city?: string, email?: string, role?: string) {
      this.id = id || null;
      this.firstname = firstname || null;
      this.lastname = lastname || null;
      this.username = username || null;
      this.password = password || null;
      this.city = city || null;
      this.email = email || null;
      this.role = role || null;
    }
  }
