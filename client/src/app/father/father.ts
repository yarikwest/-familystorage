import {Family} from '../family/family';

export class Father {
  constructor(
    public firstName: string,
    public lastName: string,
    public pesel: string,
    public birthDate: Date,
    public id?: number,
    public family?: Family) {
  }
}
