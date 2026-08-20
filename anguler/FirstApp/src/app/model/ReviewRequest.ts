export interface ReviewRequest {
  rating: number;
  comment: string;
  userId: number;
  bookId: number;
}