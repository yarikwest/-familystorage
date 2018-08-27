import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FatherComponent } from './father/father.component';
import { ChildComponent } from './child/child.component';
import { FamilyComponent } from './family/family.component';
import {FormsModule} from '@angular/forms';
import {HttpService} from './http.service';
import {HttpClientModule} from '@angular/common/http';
import { MenuComponent } from './menu/menu.component';
import { TableComponent } from './table/table.component';
import { AddFamilyComponent } from './add-family/add-family.component';
import { SearchFamilyComponent } from './search-family/search-family.component';
import { ReadFamilyComponent } from './read-family/read-family.component';
import { SearchChildComponent } from './search-child/search-child.component';
import { SearchResultComponent } from './search-result/search-result.component';

@NgModule({
  declarations: [
    AppComponent,
    FatherComponent,
    ChildComponent,
    FamilyComponent,
    MenuComponent,
    TableComponent,
    AddFamilyComponent,
    SearchFamilyComponent,
    ReadFamilyComponent,
    SearchChildComponent,
    SearchResultComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
