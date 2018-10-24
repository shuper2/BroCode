let matches = [
    {
        similarity: 86,
        name: "Abc",
        age: 5,
        gender: "male"
    },
    {
        similarity: 95,
        name: "Def",
        age: 6,
        gender: "male"
    },
    {
        similarity: 92,
        name: "Ghi",
        age: 5,
        gender: "male"
    }
];

let activeIndex = 0;

let loadMatches = (findingInfo) => {
    let { id, name, age, gender } = findingInfo;
    let success = (tmpMatches) => {
        if (tmpMatches && tmpMatches.length) matches = tmpMatches;
        else {
            console.error("Something wrong?!")
        }
    };
     $.post("/matches", findingInfo, success);
};

let updateMissingInfo = (info) => {
    let { similarity, name, age, gender } = info;
    $(".match-info .similarity").text(similarity);
    $(".match-info .name").text(name);
    $(".match-info .age").text(age);
    $(".match-info .gender").text(gender);
};

$(".carousel-control-prev").on("click", (e) => {
    if (!matches || !matches.length) return;
    if (activeIndex === 0) {
        activeIndex = matches.length - 1;
    } else {
        activeIndex--;
    }
    updateMissingInfo(matches[activeIndex]);
});

$(".carousel-control-next").on("click", (e) => {
    if (!matches || !matches.length) return;
    if (activeIndex === matches.length - 1) {
        activeIndex = 0;
    } else {
        activeIndex++;
    }
    updateMissingInfo(matches[activeIndex]);
});

$(() => {
    let id = 1;
    let name = "aac";
    let age = 5;
    let gender = "male";
    let findingInfo = { id, name, age, gender };
    loadMatches(findingInfo);
});