import {observable, action} from 'mobx';

export default class ArrowModel {

    @observable id;
    @observable.ref from;
    @observable.ref to;

    constructor(id, from, to) {
		this.id = id;
		this.from = from;
		this.to = to;
	}
}