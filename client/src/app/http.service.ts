import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Father} from './father/father';
import {Child} from './child/child';

@Injectable()
export class HttpService {

  constructor(private http: HttpClient) {
  }

  // father
  addFatherToFamily(familyId: number, father: Father) {
    return this.http.post('http://localhost:8080/family/' + familyId + '/father', father);
  }


  // child
  addChildToFamily(familyId: number, child: Child) {
    return this.http.post('http://localhost:8080/family/' + familyId + '/child', child);
  }

  searchChild(child: Child) {
    return this.http.post('http://localhost:8080/family/search', child);
  }

  // family
  createFamily() {
    return this.http.get('http://localhost:8080/family');
  }

  readFamily(familyId: number) {
    return this.http.get('http://localhost:8080/family/' + familyId);
  }
}
