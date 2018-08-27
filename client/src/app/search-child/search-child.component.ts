import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Child} from '../child/child';
import {HttpService} from '../http.service';
import {Father} from '../father/father';

@Component({
  selector: 'app-search-child',
  templateUrl: './search-child.component.html',
  styleUrls: ['./search-child.component.css']
})
export class SearchChildComponent {

  child: Child = new Child('', '', '', null, '');
  fathers: Array<Father>;
  @Output() onFathers = new EventEmitter();
  showSearchForm = true;

  constructor(private httpService: HttpService) {
  }

  findChild() {
    this.httpService.searchChild(
      new Child(this.child.firstName, this.child.lastName, this.child.pesel, this.child.birthDate, this.child.sex))
      .subscribe((data: Array<Father>) => {
        this.fathers = data;
        this.showSearchForm = !this.showSearchForm;
        this.onFathers.emit(this.fathers);
      });


  }


}
