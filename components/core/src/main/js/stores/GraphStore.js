import { observable, action } from 'mobx';
import agent from '../agent';

class GraphStore {

    @observable isLoading = false;
    @observable currentNode;
    @observable updatingNode;
    @observable updatingNodeErrors;

    @observable articlesRegistry = observable.map();
    @observable nodes = [];
    @observable links = [];

//    @action reset() {
//        this.nodes = [{ id: 'cc5e6e00' }, { id: '041f8614' }, { id: 'de36a30d' }, { id: 'bf2f06dd' }, { id: '2c1331a7' }, { id: 'e8b487fd' }, { id: 'dcb6dbd0' }, { id: '3d7e34f4' }, { id: '165f5334' }, { id: 'f2257766' }, { id: '4c7a7b5e' }, { id: '6d746a22' }, { id: '17ad7060' }, { id: '79226456' }, { id: '077f2908' }, { id: 'd7d4e98b' }, { id: '7741a467' }, { id: '43898cce' }, { id: '729cf987' }, { id: 'c5305ac5' }];
//        this.links = [{ source: 'cc5e6e00', target: '79226456' }, { source: 'cc5e6e00', target: '79226456' }, { source: 'cc5e6e00', target: '7741a467' }, { source: '041f8614', target: '165f5334' }, { source: 'de36a30d', target: 'cc5e6e00' }, { source: 'de36a30d', target: 'd7d4e98b' }, { source: 'de36a30d', target: '17ad7060' }, { source: 'bf2f06dd', target: '79226456' }, { source: 'bf2f06dd', target: '2c1331a7' }, { source: 'bf2f06dd', target: '165f5334' }, { source: 'bf2f06dd', target: '729cf987' }, { source: 'bf2f06dd', target: '17ad7060' }, { source: 'bf2f06dd', target: '4c7a7b5e' }, { source: '2c1331a7', target: '79226456' }, { source: '2c1331a7', target: '077f2908' }, { source: '2c1331a7', target: '17ad7060' }, { source: '2c1331a7', target: 'de36a30d' }, { source: '2c1331a7', target: 'cc5e6e00' }, { source: '2c1331a7', target: '4c7a7b5e' }, { source: '2c1331a7', target: '165f5334' }, { source: '2c1331a7', target: 'cc5e6e00' }, { source: 'e8b487fd', target: 'f2257766' }, { source: 'e8b487fd', target: 'd7d4e98b' }, { source: 'e8b487fd', target: 'cc5e6e00' }, { source: 'e8b487fd', target: '4c7a7b5e' }, { source: 'e8b487fd', target: '7741a467' }, { source: 'e8b487fd', target: '3d7e34f4' }, { source: 'e8b487fd', target: 'bf2f06dd' }, { source: 'e8b487fd', target: 'cc5e6e00' }, { source: 'e8b487fd', target: 'dcb6dbd0' }, { source: 'e8b487fd', target: 'de36a30d' }, { source: 'dcb6dbd0', target: 'd7d4e98b' }, { source: 'dcb6dbd0', target: 'd7d4e98b' }, { source: 'dcb6dbd0', target: '041f8614' }, { source: 'dcb6dbd0', target: '43898cce' }, { source: 'dcb6dbd0', target: '3d7e34f4' }, { source: 'dcb6dbd0', target: '7741a467' }, { source: 'dcb6dbd0', target: '6d746a22' }, { source: 'dcb6dbd0', target: '3d7e34f4' }, { source: '3d7e34f4', target: 'dcb6dbd0' }, { source: '3d7e34f4', target: '041f8614' }, { source: '165f5334', target: 'f2257766' }, { source: '165f5334', target: '4c7a7b5e' }, { source: '165f5334', target: '041f8614' }, { source: '165f5334', target: '041f8614' }, { source: '165f5334', target: 'd7d4e98b' }, { source: '165f5334', target: '077f2908' }, { source: '165f5334', target: 'dcb6dbd0' }, { source: 'f2257766', target: '17ad7060' }, { source: 'f2257766', target: '7741a467' }, { source: 'f2257766', target: '3d7e34f4' }, { source: 'f2257766', target: 'dcb6dbd0' }, { source: 'f2257766', target: 'e8b487fd' }, { source: 'f2257766', target: '2c1331a7' }, { source: 'f2257766', target: '2c1331a7' }, { source: 'f2257766', target: 'de36a30d' }, { source: 'f2257766', target: 'cc5e6e00' }, { source: 'f2257766', target: 'dcb6dbd0' }, { source: '4c7a7b5e', target: 'd7d4e98b' }, { source: '4c7a7b5e', target: '729cf987' }, { source: '4c7a7b5e', target: 'e8b487fd' }, { source: '6d746a22', target: 'e8b487fd' }, { source: '6d746a22', target: 'd7d4e98b' }, { source: '6d746a22', target: '17ad7060' }, { source: '6d746a22', target: '729cf987' }, { source: '6d746a22', target: '165f5334' }, { source: '6d746a22', target: '43898cce' }, { source: '6d746a22', target: '3d7e34f4' }, { source: '6d746a22', target: 'cc5e6e00' }, { source: '17ad7060', target: '077f2908' }, { source: '17ad7060', target: 'd7d4e98b' }, { source: '17ad7060', target: 'f2257766' }, { source: '17ad7060', target: '3d7e34f4' }, { source: '79226456', target: '729cf987' }, { source: '79226456', target: 'f2257766' }, { source: '79226456', target: '7741a467' }, { source: '79226456', target: '729cf987' }, { source: '79226456', target: 'de36a30d' }, { source: '79226456', target: 'de36a30d' }, { source: '79226456', target: 'd7d4e98b' }, { source: '79226456', target: '729cf987' }, { source: '79226456', target: 'f2257766' }, { source: '077f2908', target: 'f2257766' }, { source: '077f2908', target: '165f5334' }, { source: '077f2908', target: '041f8614' }, { source: '077f2908', target: 'cc5e6e00' }, { source: '077f2908', target: 'cc5e6e00' }, { source: 'd7d4e98b', target: '729cf987' }, { source: 'd7d4e98b', target: '729cf987' }, { source: 'd7d4e98b', target: 'bf2f06dd' }, { source: 'd7d4e98b', target: 'dcb6dbd0' }, { source: 'd7d4e98b', target: '79226456' }, { source: '7741a467', target: 'bf2f06dd' }, { source: '7741a467', target: '077f2908' }, { source: '7741a467', target: 'de36a30d' }, { source: '7741a467', target: 'f2257766' }, { source: '7741a467', target: '6d746a22' }, { source: '43898cce', target: '3d7e34f4' }, { source: '43898cce', target: 'f2257766' }, { source: '43898cce', target: '17ad7060' }, { source: '43898cce', target: '3d7e34f4' }, { source: '43898cce', target: 'd7d4e98b' }, { source: '43898cce', target: 'f2257766' }, { source: '43898cce', target: '729cf987' }, { source: 'c5305ac5', target: '4c7a7b5e' }, { source: 'c5305ac5', target: '3d7e34f4' }, { source: 'c5305ac5', target: '041f8614' }];
//    }

    @action reset() {
        this.isLoading = true;
        return agent.Graph.last()
            .then(action(({ nodes, links }) => {
                console.info(nodes);
                this.nodes = nodes;
                console.info(this.nodes);
                this.links = links;
            }))
            .finally(action(() => { this.isLoading = false; }))
    }
}

export default new GraphStore();