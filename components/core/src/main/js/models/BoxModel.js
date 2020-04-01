import { observable,action } from 'mobx';

export default class BoxModel {

	@observable id;;
	@observable name;;
	@observable x;;
	@observable y;

	constructor(id, name, x, y) {
		this.id = id;
		this.name = name;
		this.x = x;
		this.y = y
	}

	@action move(dx, dy) {
		this.x += dx;
		this.y += dy;
	}

	@action setName(name) {
		this.name = name;
	}

	get width() {
		return this.name.length * 15;
	}
}