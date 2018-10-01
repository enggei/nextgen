import { withRouter } from 'react-router-dom';
import React, { Component } from "react"
import { values } from "mobx"
import { inject, observer } from "mobx-react"
import DevTools from "mobx-react-devtools"

import Node from "./Node.js"
import Relation from "./Relation.js"
import Sidebar from "./Sidebar.js"

@inject('domainStore')
@withRouter
@observer
class Canvas extends Component {

    componentWillMount() {
        this.props.domainStore.reset();
    }

    onCanvasClick = e => {

        const { domainStore } = this.props;

        if (e.ctrlKey === false) {
            domainStore.setSelection(null)
        } else {
            domainStore.createBox("Hi.", e.clientX - 50, e.clientY - 20, domainStore.selection)
        }
    }

    render() {

        const { domainStore } = this.props;

        return (
            <div>
                <div className="canvas" onClick={this.onCanvasClick}>
                    <svg>
                        {domainStore.arrows.map(arrow => <Relation arrow={arrow} key={arrow.id} />)}
                    </svg>
                    { values(domainStore.boxMap).map(box => (<Node box={box} domainStore={domainStore} key={box.id} />)) }
                </div>
                <Sidebar domainStore={domainStore} />
                <DevTools />
            </div>
        )
    }

}

export default Canvas;