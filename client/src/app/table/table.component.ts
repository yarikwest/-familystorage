import {Component} from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent {

  showAdd = false;
  showSearch = false;

  showAddFamily() {
    if (this.showSearch) {
      this.showSearch = !this.showSearch;
    }
    this.showAdd = !this.showAdd;
  }

  showSearchFamily() {
    if (this.showAdd) {
      this.showAdd = !this.showAdd;
    }
    this.showSearch = !this.showSearch;
  }

}
