import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientesComponent } from './components/clientes/clientes.component';
import { FacturasComponent } from './components/facturas/facturas.component';
import { ProductosComponent } from './components/productos/productos.component';

const routes: Routes = [
  {path:'', pathMatch:'full', redirectTo:'productos'},
  {path:'clientes', component: ClientesComponent},
  {path:'facturas', component: FacturasComponent},
  {path:'productos', component: ProductosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
