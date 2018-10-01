import {observable, action} from 'mobx';

export default class BoxModel {

    @observable id;
    @observable name;
    @observable x;
    @observable y;

    constructor(id, name, x, y) {
		this.id = id;
		this.name = name;
		this.x = x;
		this.y = y;
	}

    get width() {
        return this.name.length * 15;
    };

    @action move(dx, dy) {
        this.x += dx;
        this.y += dy;
    }

    @action setName(username) {
        this.name = name;
    }
}