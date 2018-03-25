import { Component } from '@angular/core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {
    private _message = '';
    public get message(): string
    {
        return this._message;
    }

    public set message(value: string)
    {
        console.log('updating message to ', value);
        this._message = value;
    }

    public sendAlert(message: string)
    {
        alert(message);
    }
}
