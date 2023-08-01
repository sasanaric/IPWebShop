export class ProductAttribute {
    attributeName: string | null;
    value: string | null;
    
    constructor(attributeName?: string, value?: string) {
        this.attributeName = attributeName || null;
        this.value = value || null;
    }
  }
