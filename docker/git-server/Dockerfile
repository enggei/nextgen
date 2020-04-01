FROM alpine:3.7

RUN apk add --no-cache \
  openssh \
  git

# Key generation on the server
RUN ssh-keygen -A

WORKDIR /git-server/

# -D flag avoids password generation
# -s flag changes user's shell
RUN mkdir /git-server/keys \
  && adduser -D -s /usr/bin/git-shell git \
  && echo git:12345 | chpasswd \
  && mkdir /home/git/.ssh

COPY init-repo.sh init-repo.sh
COPY delete-repo.sh delete-repo.sh

# This is a login shell for SSH accounts to provide restricted Git access.
# It permits execution only of server-side Git commands implementing the
# pull/push functionality, plus custom commands present in a subdirectory
# named git-shell-commands in the user’s home directory.
# More info: https://git-scm.com/docs/git-shell
#COPY git-shell-commands /home/git/git-shell-commands
RUN mkdir /home/git/git-shell-commands \
  && chown git:git /home/git/git-shell-commands

# sshd_config file is edited for enable access key and disable access password
COPY sshd_config /etc/ssh/sshd_config
COPY start.sh start.sh

EXPOSE 22

CMD ["sh", "start.sh"]