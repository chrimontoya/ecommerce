export interface CustomResponse<T> {
    message: string;
    status: number;
    data: T | T[];
}