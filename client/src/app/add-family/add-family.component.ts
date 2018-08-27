import {Component, ViewChild} from '@angular/core';
import {Family} from '../family/family';
import {HttpService} from '../http.service';
import {ReadFamilyComponent} from '../read-family/read-family.component';

@Component({
  selector: 'app-add-family',
  templateUrl: './add-family.component.html',
  styleUrls: ['./add-family.component.css']
})
export class AddFamilyComponent {

  showForm = false;
  family: Family;
  familyId: number;
  @ViewChild(ReadFamilyComponent) private readFamilyComp: ReadFamilyComponent;

  constructor(private httpService: HttpService) {
  }

  createFamily() {
    this.httpService.createFamily().subscribe((data: Family) => {
      this.family = data;
      this.familyId = this.family.id;
    });

    this.showForm = !this.showForm;
  }

  readFamily() {
    this.readFamilyComp.readFamily(this.familyId);
  }


}
