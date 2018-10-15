FROM fluent/fluentd:stable

ADD ./conf/fluent.conf /fluentd/etc/fluent.conf
ADD ./conf/nextgen_template.json /fluentd/etc/nextgen_template.json

RUN ["gem", "install", "fluent-plugin-elasticsearch", "--no-rdoc", "--no-ri"]
RUN ["gem", "install", "fluent-plugin-multi-format-parser", "--no-rdoc", "--no-ri"]
#RUN ["gem", "install", "fluent-plugin-rename-key", "--no-rdoc", "--no-ri"]
#RUN ["gem", "install", "fluent-plugin-rewrite-tag-filter", "--no-rdoc", "--no-ri"]
#RUN ["gem", "install", "fluent-plugin-record-modifier", "--no-rdoc", "--no-ri"]
RUN ["gem", "install", "fluent-plugin-forest", "--no-rdoc", "--no-ri"]
