import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StocksListComponent} from "./stocks-list/stocks-list.component";

const routes: Routes = [
  { path: '', redirectTo: 'stocks', pathMatch: 'full' },
  { path: 'stocks', component: StocksListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
