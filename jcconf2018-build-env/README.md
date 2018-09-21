# Jcconf2018 Build Env

- direct run (need `docker` and `make`)
    ```sh
    $ make
    ```

- run with out make (need `docker`)
    - windows-cmd:
        ```sh
        $ docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock -v "%cd%":/data softleader/dmake
        ```
    - windows-powershell:
        ```sh
        $ docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock -v ${pwd}:/data softleader/dmake
        ```
    - unix:
        ```sh
        $ docker run -it --rm -v /var/run/docker.sock:/var/run/docker.sock -v "$(pwd)":/data softleader/dmake
        ```
