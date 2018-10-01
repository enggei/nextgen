import { observable, action, computed } from 'mobx';

import BoxModel from "../models/BoxModel";
import ArrowModel from "../models/ArrowModel";
import { randomUuid } from "../utils";

class DomainStore {

    @observable boxMap = observable.map();
    @observable arrows = [];
    @observable selection;

    reset() {

        this.boxMap.clear();
        this.arrows.clear();

        this.boxMap.set("ce9131ee-f528-4952-a012-543780c5e66d", new BoxModel("ce9131ee-f528-4952-a012-543780c5e66d","Rotterdam", 10, 10));
        this.boxMap.set("14194d76-aa31-45c5-a00c-104cc550430f", new BoxModel("14194d76-aa31-45c5-a00c-104cc550430f","Bratislava", 10, 10));

        this.arrows.push(new ArrowModel("7b5d33c1-5e12-4278-b1c5-e4ae05c036bd", this.boxMap.get("ce9131ee-f528-4952-a012-543780c5e66d"), this.boxMap.get("14194d76-aa31-45c5-a00c-104cc550430f")));

    }

    @action addBox(name, x, y) {
        const box = new BoxModel(randomUuid(), name, x, y);
        this.boxMap.set(box.id, box);
        return box;
    };

    @action addArrow(from, to) {
        this.arrows.push(new ArrowModel(randomUuid(), from, to));
    };

    @action setSelection(selection) {
        this.selection = selection;
    };

    @action createBox(name, x, y, source) {
        const box = this.addBox(name, x, y);
        this.setSelection(box);
        if (source) this.addArrow(source.id, box.id);
    };
    
}

export default new DomainStore();