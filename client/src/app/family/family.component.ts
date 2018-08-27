import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Family} from './family';

@Component({
  selector: 'app-family',
  templateUrl: './family.component.html',
  styleUrls: ['./family.component.css']
})
export class FamilyComponent {

  @Input() showFormFamily;
  @Input() family: Family;
  @Output() readFamily = new EventEmitter();
  showFormChild = false;
  showFormFather = true;
  disableButtonSaveFamily = true;

  hiddenFatherForm() {
    this.showFormFather = !this.showFormFather;
    this.showFormChild = !this.showFormChild;
  }

  onReadFamily() {
    this.showFormChild = !this.showFormChild;
    this.readFamily.emit();
  }

  disableSaveFamily() {
    this.disableButtonSaveFamily = false;
  }

}
