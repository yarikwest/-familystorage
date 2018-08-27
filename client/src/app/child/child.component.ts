import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Child} from './child';
import {Family} from '../family/family';
import {HttpService} from '../http.service';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent {

  children: Array<Child> = [];
  child: Child = new Child('', '', '', null, '');
  retChild: Child;
  @Input() family: Family;
  @Output() disableSaveFamily = new EventEmitter();

  constructor(private httpService: HttpService) {
  }

  addChildToFamily() {
    const newChild: Child = new Child(this.child.firstName, this.child.lastName, this.child.pesel, this.child.birthDate, this.child.sex);
    this.children.push(newChild);

    this.httpService.addChildToFamily(this.family.id, newChild)
      .subscribe((data: Child) => this.retChild = data);

    this.disableSaveFamily.emit();
  }
}
