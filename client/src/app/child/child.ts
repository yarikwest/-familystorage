import {Family} from '../family/family';

export class Child {

  constructor(
    public firstName: string,
    public lastName: string,
    public pesel: string,
    public birthDate: Date,
    public sex: string,
    public id?: number,
    public family?: Family) {
  }
}
