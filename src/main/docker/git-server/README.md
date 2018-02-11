# Git server docker image

Based on [git-server-docker](https://github.com/jkarlosb/git-server-docker)

## Environment variables

```text
GIT_SERVER_KEYS=/path/to/git-server-keys
```

## Preparation

```bash
sudo su -c "mkdir -p $GIT_SERVER_KEYS && cp ~/.ssh/id_rsa.pub $GIT_SERVER_KEYS/user.pub"
```

## Adding keys to the repository

Copy new user's key as shown above (give it a unique name with suffix .pub), and then restart the container.

## Managing repositories

```bash
# Connect to the container
docker exec -ti nextgen_gitserver_1 sh
```

### Create
```bash
./init-repo.sh reponame
```


### Delete
```bash
./delete-repo.sh reponame
```

## Usage

```bash
# Clone repo
git clone ssh://git@localhost:2222/git-server/repos/reponame.git
```
