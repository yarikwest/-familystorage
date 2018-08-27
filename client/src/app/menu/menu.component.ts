import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  @Output() addFamily = new EventEmitter();
  @Output() searchFamily = new EventEmitter();

  onAddFamily() {
    this.addFamily.emit();
  }

  onSearchFamily() {
    this.searchFamily.emit();
  }

}
