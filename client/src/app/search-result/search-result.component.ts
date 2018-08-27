import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Father} from '../father/father';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent {

  @Input() fathers: Array<Father>;
  @Input() showSearchResult;
  @Output() findSelectedFamily = new EventEmitter();

  showSelectedRow(familyId: number) {
    this.findSelectedFamily.emit(familyId);
  }
}
