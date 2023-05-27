import { Observable } from "rxjs";

export interface IService<T> {

    apiUrl: string;

    //Observable é uma coleção que retorna os valores de seus itens usando as requisições por meio de notificações
    // é como se fizesse uma chamada de função que retora multiplos valores ao longo do tempo
    get(termoBusca?: string): Observable<T[]>;//Lista tudo
    getById(id: number): Observable<T>;
    insert(objeto: T): Observable<T>;//operação na camda de serviço que leva ao endpoint
    update(objeto: T): Observable<T>;//operação na camda de serviço que leva ao endpoint
    delete(id: number): Observable<void>;
}
