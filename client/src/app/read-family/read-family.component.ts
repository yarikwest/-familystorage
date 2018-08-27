import {Component, Input} from '@angular/core';
import {HttpService} from '../http.service';

@Component({
  selector: 'app-read-family',
  templateUrl: './read-family.component.html',
  styleUrls: ['./read-family.component.css']
})
export class ReadFamilyComponent {

  familyArray: Array<any> = [];
  showReadFamily = false;

  constructor(private httpService: HttpService) {
  }

  readFamily(familyId: number) {
    this.httpService.readFamily(familyId).subscribe((data: Array<any>) => this.familyArray = data);
    this.showReadFamily = !this.showReadFamily;
  }
}
