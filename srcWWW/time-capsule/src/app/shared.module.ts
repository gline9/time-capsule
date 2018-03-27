import { NgModule } from '@angular/core';
import { MdcTextFieldModule, MdcButtonModule } from '@angular-mdc/web';

const imports = [
    MdcTextFieldModule,
    MdcButtonModule
];

@NgModule({
    imports: [...imports],
    exports: [...imports]
})
export class SharedModule
{

}
