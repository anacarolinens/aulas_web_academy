import { NgForm } from "@angular/forms";

export interface IForm<T> { //objeto do tipo genérico

    registro: T;

    submit(form: NgForm): void;
}
