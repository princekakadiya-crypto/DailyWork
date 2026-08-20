export interface Book {
  bookId: number;
  title: string;
  price: number;
  ISBN: string | null;
  stock: number;
}