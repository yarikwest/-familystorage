import {Component, ViewChild} from '@angular/core';
import {Father} from '../father/father';
import {ReadFamilyComponent} from '../read-family/read-family.component';

@Component({
  selector: 'app-search-family',
  templateUrl: './search-family.component.html',
  styleUrls: ['./search-family.component.css']
})
export class SearchFamilyComponent {

  fathers: Array<Father>;
  showSearchResult = false;
  @ViewChild(ReadFamilyComponent) private readFamilyComp: ReadFamilyComponent;

  onFathers(onFathers: any) {
    this.fathers = onFathers;
    this.showSearchResult = !this.showSearchResult;
  }

  findSelectedFamily(familyId: number) {
    this.showSearchResult = !this.showSearchResult;
    this.readFamilyComp.readFamily(familyId);
  }
}
