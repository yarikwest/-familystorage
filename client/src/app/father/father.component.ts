import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Father} from './father';
import {Family} from '../family/family';
import {HttpService} from '../http.service';

@Component({
  selector: 'app-father',
  templateUrl: './father.component.html',
  styleUrls: ['./father.component.css']
})
export class FatherComponent {

  father: Father = new Father('', '', '', null);
  retFather: Father;

  @Input() family: Family;
  @Output() addFather = new EventEmitter();

  constructor(private httpService: HttpService) {
  }


  addFatherToFamily() {
    this.httpService.addFatherToFamily(this.family.id,
      new Father(this.father.firstName, this.father.lastName, this.father.pesel, this.father.birthDate))
      .subscribe((data: Father) => this.retFather = data);

    this.addFather.emit();
  }
}
