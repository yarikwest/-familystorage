import {Component, ViewChild} from '@angular/core';
import {TableComponent} from './table/table.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  @ViewChild(TableComponent) private table: TableComponent;

  inAddFamily() {
    this.table.showAddFamily();
  }

  inSearchFamily() {
    this.table.showSearchFamily();
  }
}
