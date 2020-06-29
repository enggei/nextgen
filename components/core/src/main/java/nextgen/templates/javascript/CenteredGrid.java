package nextgen.templates.javascript;

public class CenteredGrid {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	CenteredGrid(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CenteredGrid");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CenteredGrid that = (CenteredGrid) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CenteredGrid() ::= <<import React from 'react';\n" + 
				"import { makeStyles } from '@material-ui/core/styles';\n" + 
				"import Paper from '@material-ui/core/Paper';\n" + 
				"import Grid from '@material-ui/core/Grid';\n" + 
				"\n" + 
				"import Loading from './Loading';\n" + 
				"\n" + 
				"const useStyles = makeStyles((theme) => ({\n" + 
				"  root: {\n" + 
				"    flexGrow: 1,\n" + 
				"  },\n" + 
				"  paper: {\n" + 
				"    padding: theme.spacing(2),\n" + 
				"    textAlign: 'center',\n" + 
				"    color: theme.palette.text.secondary,\n" + 
				"  },\n" + 
				"}));\n" + 
				"\n" + 
				"export default function CenteredGrid(props) {\n" + 
				"  const classes = useStyles();\n" + 
				"\n" + 
				"  return (\n" + 
				"    <div className={classes.root}>\n" + 
				"      <Grid container spacing={3}>\n" + 
				"        <Grid item xs={12}>\n" + 
				"          <Paper className={classes.paper}>{props.status ? props.status.header : <Loading/> }</Paper>\n" + 
				"        </Grid>\n" + 
				"        <Grid item xs={6}>\n" + 
				"          <Paper className={classes.paper}>xs=6</Paper>\n" + 
				"        </Grid>\n" + 
				"        <Grid item xs={6}>\n" + 
				"          <Paper className={classes.paper}>xs=6</Paper>\n" + 
				"        </Grid>\n" + 
				"        <Grid item xs={3}>\n" + 
				"          <Paper className={classes.paper}>xs=3</Paper>\n" + 
				"        </Grid>\n" + 
				"        <Grid item xs={3}>\n" + 
				"          <Paper className={classes.paper}>xs=3</Paper>\n" + 
				"        </Grid>\n" + 
				"        <Grid item xs={3}>\n" + 
				"          <Paper className={classes.paper}>xs=3</Paper>\n" + 
				"        </Grid>\n" + 
				"        <Grid item xs={3}>\n" + 
				"          <Paper className={classes.paper}>xs=3</Paper>\n" + 
				"        </Grid>\n" + 
				"      </Grid>\n" + 
				"    </div>\n" + 
				"  );\n" + 
				"} >>";
}  