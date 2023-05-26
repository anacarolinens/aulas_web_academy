export interface IList<T> {//definindo o tipo genérico
    //propriedade que registra os registros
    registros: T[];

    //definição de comportamento básico
    get(termoBusca?: string): void;
    //identifica qual o registro que será removido da aplicação
    delete(id: number): void;
}
