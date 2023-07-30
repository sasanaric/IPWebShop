export class LoginRequest {
  username: string | null;
  password: string | null;

  constructor(username?: string, password?: string) {
      this.username = username || null;
      this.password = password || null;
  }
}
