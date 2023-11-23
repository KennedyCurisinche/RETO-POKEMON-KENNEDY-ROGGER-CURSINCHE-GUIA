
    $(document).on('click', '#exit', function() {

        $("#hasgenderdifferences").removeAttr("checked");
        $("#isbaby").removeAttr("checked");
        $("#islegendary").removeAttr("checked");
        $("#ismythical").removeAttr("checked");

        $("#modalempleado").modal("hide");
    });

    $(document).on('click', '.details', function() {

        let details = $(this).attr("data-details")

        $.ajax({
            type: 'GET',
            url: details,
            dataType: 'json',
            success: function(result) {

                if (result != null) {

                    $("#txtid").val(result.id);
                    $("#txtname").val(result.name);
                    $("#txtcolor").val(result.color.name);
                    $("#txtgeneration").val(result.generation.name);
                    $("#txthabitat").val(result.habitat.name);
                    $("#txtshape").val(result.shape.name);

                    if(result.is_baby) {
                        $("#hasgenderdifferences").attr("checked", "checked");
                    }

                    if(result.is_baby) {
                        $("#isbaby").attr("checked", "checked");
                    }

                    if(result.is_legendary) {
                        $("#islegendary").attr("checked", "checked");
                    }

                    if(result.is_mythical) {
                        $("#ismythical").attr("checked", "checked");
                    }

                    $("#modaldetail").modal("show");

                } else {

                    swal.fire({
                        position: 'center',
                        icon: 'error',
                        title: "NO RESULT",
                        showConfirmButton: false,
                        timer: 1500
                    })

                }

            }

        })

    });

    $(document).on('click', '.previous', function() {

        let previous = $(this).attr("data-previous")

        $.ajax({
            type: 'GET',
            url: previous,
            dataType: 'json',
            success: function(result) {

                if (result != null) {

                    getBodyHTML(result)

                } else {

                    swal.fire({
                        position: 'center',
                        icon: 'error',
                        title: "NO RESULT",
                        showConfirmButton: false,
                        timer: 1500
                    })

                }

            }

        })


	});


	$(document).on('click', '.next', function() {

        let next = $(this).attr("data-next")

        $.ajax({
            type: 'GET',
            url: next,
            dataType: 'json',
            success: function(result) {

                if (result != null) {

                    getBodyHTML(result)

                } else {

                    swal.fire({
                        position: 'center',
                        icon: 'error',
                        title: "NO RESULT",
                        showConfirmButton: false,
                        timer: 1500
                      })

                }

            }

        })

    });


    function getBodyHTML(result) {

        $(".row").html("");
        $.each(result.results, function(index, value){

            $(".row").append(`

                <div class="col-12 col-sm-4 col-xl-2">

                    <div class="card">

                        <div class="card-body">

                            <p class="card-text">${value.name}</p>

                            </br>

                            <button type="button" class="btn btn-primary details" data-details="${value.url}">Details</button>

                        </div>

                    </div>

                    </br>

                </div>

            `)

        });

        $("#previous").attr("data-previous", result.previous);
        $("#next").attr("data-next", result.next);

    }
