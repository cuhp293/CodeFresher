var goals = [];

function addGoal() {
  var goalInput = document.getElementById("goalInput").value;
  var tagInput = document.getElementById("tagInput").value;

  if (goalInput === "") {
    alert("Please enter a goal!");
    return;
  }

  var newGoal = {
    content: goalInput,
    tag: tagInput,
    createdDate: new Date().toLocaleDateString(),
    star: false,
  };
  goals.push(newGoal);
  displayGoals();
  document.getElementById("goalInput").value = "";
  document.getElementById("tagInput").value = "";
}

function displayGoals() {
  var ul = document.getElementById("goalList");
  ul.innerHTML = "";

  goals.forEach(function (goal, index) {
    var li = document.createElement("li");
    li.innerHTML = `
            <div class="goal-content">
                <span>${goal.content}</span>
                <span class="tag">${goal.tag}</span>
                <span>${goal.createdDate}</span>
                <div class="goal-actions">
                    <button onclick="editGoal(${index})"><i class="fas fa-edit"></i></button>
                    <button onclick="deleteGoal(${index})"><i class="fas fa-trash-alt"></i></button>
                </div>
            </div>
            <div class="star-icon">
                <i class="fas fa-star${goal.star ? "" : "-o"}"></i>
            </div>
        `;
    ul.appendChild(li);
  });
}

function deleteGoal(index) {
  goals.splice(index, 1);
  displayGoals();
}

function editGoal(index) {
  var newContent = prompt("Enter new content for the goal:");
  if (newContent !== null) {
    goals[index].content = newContent;
    displayGoals();
  }
}
