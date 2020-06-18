package nextgen.templates.javascript;

public class Status {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	Status(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Status");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Status that = (Status) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Status() ::= <<import React from 'react';\n" + 
				"import clsx from 'clsx';\n" + 
				"import { makeStyles } from '@material-ui/core/styles';\n" + 
				"import CssBaseline from '@material-ui/core/CssBaseline';\n" + 
				"import Drawer from '@material-ui/core/Drawer';\n" + 
				"import Box from '@material-ui/core/Box';\n" + 
				"import AppBar from '@material-ui/core/AppBar';\n" + 
				"import Toolbar from '@material-ui/core/Toolbar';\n" + 
				"import List from '@material-ui/core/List';\n" + 
				"import Typography from '@material-ui/core/Typography';\n" + 
				"import Divider from '@material-ui/core/Divider';\n" + 
				"import IconButton from '@material-ui/core/IconButton';\n" + 
				"import Badge from '@material-ui/core/Badge';\n" + 
				"import Container from '@material-ui/core/Container';\n" + 
				"import Grid from '@material-ui/core/Grid';\n" + 
				"import Paper from '@material-ui/core/Paper';\n" + 
				"import Link from '@material-ui/core/Link';\n" + 
				"import MenuIcon from '@material-ui/icons/Menu';\n" + 
				"import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';\n" + 
				"import NotificationsIcon from '@material-ui/icons/Notifications';\n" + 
				"import { mainListItems, secondaryListItems } from './listItems';\n" + 
				"\n" + 
				"\n" + 
				"import Copyright from '../components/Copyright';\n" + 
				"\n" + 
				"const drawerWidth = 240;\n" + 
				"\n" + 
				"const useStyles = makeStyles((theme) => ({\n" + 
				"	root: {\n" + 
				"		display: 'flex',\n" + 
				"	},\n" + 
				"	toolbar: {\n" + 
				"		paddingRight: 24, // keep right padding when drawer closed\n" + 
				"	},\n" + 
				"	toolbarIcon: {\n" + 
				"		display: 'flex',\n" + 
				"		alignItems: 'center',\n" + 
				"		justifyContent: 'flex-end',\n" + 
				"		padding: '0 8px',\n" + 
				"		...theme.mixins.toolbar,\n" + 
				"	},\n" + 
				"	appBar: {\n" + 
				"		zIndex: theme.zIndex.drawer + 1,\n" + 
				"		transition: theme.transitions.create(['width', 'margin'], {\n" + 
				"			easing: theme.transitions.easing.sharp,\n" + 
				"			duration: theme.transitions.duration.leavingScreen,\n" + 
				"		}),\n" + 
				"	},\n" + 
				"	appBarShift: {\n" + 
				"		marginLeft: drawerWidth,\n" + 
				"		width: `calc(100% - ${drawerWidth}px)`,\n" + 
				"		transition: theme.transitions.create(['width', 'margin'], {\n" + 
				"			easing: theme.transitions.easing.sharp,\n" + 
				"			duration: theme.transitions.duration.enteringScreen,\n" + 
				"		}),\n" + 
				"	},\n" + 
				"	menuButton: {\n" + 
				"		marginRight: 36,\n" + 
				"	},\n" + 
				"	menuButtonHidden: {\n" + 
				"		display: 'none',\n" + 
				"	},\n" + 
				"	title: {\n" + 
				"		flexGrow: 1,\n" + 
				"	},\n" + 
				"	drawerPaper: {\n" + 
				"		position: 'relative',\n" + 
				"		whiteSpace: 'nowrap',\n" + 
				"		width: drawerWidth,\n" + 
				"		transition: theme.transitions.create('width', {\n" + 
				"			easing: theme.transitions.easing.sharp,\n" + 
				"			duration: theme.transitions.duration.enteringScreen,\n" + 
				"		}),\n" + 
				"	},\n" + 
				"	drawerPaperClose: {\n" + 
				"		overflowX: 'hidden',\n" + 
				"		transition: theme.transitions.create('width', {\n" + 
				"			easing: theme.transitions.easing.sharp,\n" + 
				"			duration: theme.transitions.duration.leavingScreen,\n" + 
				"		}),\n" + 
				"		width: theme.spacing(7),\n" + 
				"		[theme.breakpoints.up('sm')]: {\n" + 
				"			width: theme.spacing(9),\n" + 
				"		},\n" + 
				"	},\n" + 
				"	appBarSpacer: theme.mixins.toolbar,\n" + 
				"	content: {\n" + 
				"		flexGrow: 1,\n" + 
				"		height: '100vh',\n" + 
				"		overflow: 'auto',\n" + 
				"	},\n" + 
				"	container: {\n" + 
				"		paddingTop: theme.spacing(4),\n" + 
				"		paddingBottom: theme.spacing(4),\n" + 
				"	},\n" + 
				"	paper: {\n" + 
				"		padding: theme.spacing(2),\n" + 
				"		display: 'flex',\n" + 
				"		overflow: 'auto',\n" + 
				"		flexDirection: 'column',\n" + 
				"	},\n" + 
				"	fixedHeight: {\n" + 
				"		height: 240,\n" + 
				"	},\n" + 
				"}));\n" + 
				"\n" + 
				"export default function Dashboard() {\n" + 
				"	const classes = useStyles();\n" + 
				"	const [open, setOpen] = React.useState(true);\n" + 
				"	const handleDrawerOpen = () => {\n" + 
				"		setOpen(true);\n" + 
				"	};\n" + 
				"	const handleDrawerClose = () => {\n" + 
				"		setOpen(false);\n" + 
				"	};\n" + 
				"	const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);\n" + 
				"	\n" + 
				"	return (\n" + 
				"		<div className={classes.root}>\n" + 
				"			<AppBar position=\"absolute\" className={clsx(classes.appBar, open && classes.appBarShift)}>\n" + 
				"			<Toolbar className={classes.toolbar}>\n" + 
				"				<IconButton\n" + 
				"					edge=\"start\"\n" + 
				"					color=\"inherit\"\n" + 
				"					aria-label=\"open drawer\"\n" + 
				"					onClick={handleDrawerOpen}\n" + 
				"					className={clsx(classes.menuButton, open && classes.menuButtonHidden)}\n" + 
				"				>\n" + 
				"					<MenuIcon />\n" + 
				"				</IconButton>\n" + 
				"				<Typography component=\"h1\" variant=\"h6\" color=\"inherit\" noWrap className={classes.title}>\n" + 
				"					Dashboard\n" + 
				"				</Typography>\n" + 
				"				<IconButton color=\"inherit\">\n" + 
				"					<Badge badgeContent={4} color=\"secondary\">\n" + 
				"					<NotificationsIcon />\n" + 
				"					</Badge>\n" + 
				"				</IconButton>\n" + 
				"			</Toolbar>\n" + 
				"			</AppBar>\n" + 
				"			<Drawer\n" + 
				"			variant=\"permanent\"\n" + 
				"			classes={{\n" + 
				"				paper: clsx(classes.drawerPaper, !open && classes.drawerPaperClose),\n" + 
				"			}}\n" + 
				"			open={open}\n" + 
				"			>\n" + 
				"			<div className={classes.toolbarIcon}>\n" + 
				"				<IconButton onClick={handleDrawerClose}>\n" + 
				"					<ChevronLeftIcon />\n" + 
				"				</IconButton>\n" + 
				"			</div>\n" + 
				"			<Divider />\n" + 
				"			<List>{mainListItems}</List>\n" + 
				"			<Divider />\n" + 
				"			<List>{secondaryListItems}</List>\n" + 
				"			</Drawer>\n" + 
				"			<main className={classes.content}>\n" + 
				"			<div className={classes.appBarSpacer} />\n" + 
				"			<Container maxWidth=\"lg\" className={classes.container}>\n" + 
				"				<Grid container spacing={3}>\n" + 
				"					{/* Chart */}\n" + 
				"					<Grid item xs={12} md={8} lg={9}>\n" + 
				"					<Paper className={fixedHeightPaper}>\n" + 
				"						<Chart />\n" + 
				"					</Paper>\n" + 
				"					</Grid>\n" + 
				"					{/* Recent Deposits */}\n" + 
				"					<Grid item xs={12} md={4} lg={3}>\n" + 
				"					<Paper className={fixedHeightPaper}>\n" + 
				"						<Deposits />\n" + 
				"					</Paper>\n" + 
				"					</Grid>\n" + 
				"					{/* Recent Orders */}\n" + 
				"					<Grid item xs={12}>\n" + 
				"					<Paper className={classes.paper}>\n" + 
				"						<Orders />\n" + 
				"					</Paper>\n" + 
				"					</Grid>\n" + 
				"				</Grid>\n" + 
				"				<Box pt={4}>\n" + 
				"					<Copyright />\n" + 
				"				</Box>\n" + 
				"			</Container>\n" + 
				"			</main>\n" + 
				"		</div>\n" + 
				"	);\n" + 
				"} >>";
} 