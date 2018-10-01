import React, { Component } from "react"
import { observer } from "mobx-react"

@observer
class Relation extends Component {

     render() {

        const { from, to } = this.props.arrow;

        if (!from || !to) return null;

        const [x1, y1, x2, y2] = [from.x + from.width / 2, from.y + 30, to.x + to.width / 2, to.y + 30];

        return <path className="arrow" d={`M${x1} ${y1} L${x2} ${y2}`} />
    }
}

export default Relation;