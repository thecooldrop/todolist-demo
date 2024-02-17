import { Routes } from '@angular/router';
import { HelloComponent } from './hello/hello.component';
import { AuthGuard } from './auth.guard';


export const routes: Routes = [
    { path: 'hello', component: HelloComponent, canActivate: [AuthGuard] }
];
